package jp.kadai;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomerDataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = null;
        resp.setContentType("text/html");
        PersistenceManager pm = PMF.get().getPersistenceManager();
        
        String name = req.getParameter("name"); //客の名前
        String order = req.getParameter("order"); //注文するピザのデータストアのIDが入る
        String count = req.getParameter("count"); //枚数が入る
        Date date = Calendar.getInstance().getTime();
        String ordername = "";
        String orderid = order;
        int price = 0;
        
        String query = "select from " + PizzaData.class.getName() + " where id == " + order;
        List<PizzaData> datas = (List<PizzaData>) pm.newQuery(query).execute();
        for(PizzaData data : datas) {
        	ordername = data.getName();
        	price = Integer.parseInt(data.getPrice());
        }
        order = ordername;
        price = price * Integer.parseInt(count);
        String orderprice = Integer.toString(price);
      
        CustomerData data = new CustomerData(name, ordername, count, date);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
    		req.setAttribute("price", orderprice); //ピザの値段
    		req.setAttribute("pizza", ordername); //頼んだピザの名前
    		req.setAttribute("name", name); //客の名前
    		req.setAttribute("count", count); //ピザの枚数
    		rd = req.getRequestDispatcher("/shop.jsp");
        } finally {
            manager.close();
    		rd.forward(req, resp);
        }
    }
}
