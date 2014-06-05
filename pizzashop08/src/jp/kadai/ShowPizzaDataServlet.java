package jp.kadai;
import java.io.*;
import java.util.*;

import javax.jdo.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ShowPizzaDataServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<PizzaData> list = null;
        
        if (param1 == null || param1 ==""){
            String query = "select from " + PizzaData.class.getName();
            try {
                list = (List<PizzaData>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                PizzaData data = (PizzaData)manager.getObjectById(PizzaData.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(PizzaData data:list){
                res += "{id:" + data.getId() + ",price:'" + data.getPrice() + "',name:'" +
                    data.getName() + "',date:'" + data.getDatetime() +
                    "',comment:'" + data.getComment() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}