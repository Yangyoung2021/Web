package cn.project.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@WebFilter("/*")
public class SensitiveFilter implements Filter {
    List<String> list;

    public void init(FilterConfig config) throws ServletException {
        try {
            //2.1获取敏感词汇文件，读取到List集合中
            String realPath = config.getServletContext().getRealPath("/WEB-INF/classes/sensitive.txt");

            list = new ArrayList<>();

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "gbk"));

            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        if(uri.contains("/add.jsp") || uri.contains("/addServlet") || uri.contains("/js/") ||
//                uri.contains("/css/") || uri.contains("/font/") || uri.contains("/checkCode")){
//            //访问登录相关资源，应当放行
//            chain.doFilter(request,response);
//        }
            ServletRequest sensitive = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(),
            request.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String name;
                    if ("getParameter".equals(method.getName())) {
                        //获取相对应的方法

                        //1.调用方法，获取返回值
                        name = (String) method.invoke(request, args);

                        //2.判断方法中是否有敏感词汇，有就更改
                        if (name == null) {
                            name = "";
                        }

                        for (String s : list) {
                            if (name.contains(s)) {
                                name = name.replace(s, "***");
                            }
                        }

                        return name;
                    }

                    if ("getParameterMap".equals(method.getName())) {

                        Map<String, String[]> parameterMap = (Map<String, String[]>) method.invoke(request);

//                        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//                        for (Map.Entry<String, String[]> entry : entries) {
//                            for (String str : list) {
//                                if (Arrays.toString(entry.getValue()).contains(str)){
//                                    String s = Arrays.toString(entry.getValue()).replaceAll(str, "***");
//                                    entry.setValue(new String[]{s});
//                                }
//                            }
//                        }
//
//                        return parameterMap;

                        Map<String, String[]> replacedMap = new HashMap<>();
                        Set<String> strings = parameterMap.keySet();//strings
                        for (String string : strings) {
                            String strings1 = parameterMap.get(string)[0]; //Strings1 就是值的数组
                            if (strings1 != null) {
                                for (String str : list) {
                                    if (strings1.contains(str)) {
                                        strings1 = strings1.replaceAll(str, "***");
                                    }
                                }
                            }
                            replacedMap.put(string, new String[]{strings1});
                        }
                        return replacedMap;
                    }


                    return method.invoke(request, args);
                }

            });
            chain.doFilter(sensitive, response);
//            String name = sensitive.getParameter("name");
//            System.out.println(name);
//
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
//
//            Map<String, String[]> parameterMap = sensitive.getParameterMap();
//            Set<String> strings = parameterMap.keySet();
//            for (String string : strings) {
//                String[] strings1 = parameterMap.get(string);
//                System.out.println(Arrays.toString(strings1));
//            }

    }
}
