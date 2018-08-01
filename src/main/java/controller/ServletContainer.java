package controller;

import model.services.CarsPark;
import model.services.Compare;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static view.TextConstant.MESSAGES_BUNDLE_NAME;
import static view.TextConstant.WRONG_INPUT_DATA;

@WebServlet(urlPatterns = "/home")

public class ServletContainer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int min = Integer.parseInt(req.getParameter("min"));
        int max = Integer.parseInt(req.getParameter("max"));
        String lang = req.getParameter("lang");
        System.out.println(lang);
        ResourceBundle bundle = ResourceBundle.getBundle(
                MESSAGES_BUNDLE_NAME,new Locale(lang));
        System.out.println(lang);

        String error = null;
        if(min > max){
            error = bundle.getString(WRONG_INPUT_DATA);
        }
        if(error != null){
            req.setAttribute("error",error);

            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("/WEB-INF/views/startPage.jsp");
            dispatcher.forward(req, resp);
        } else {
            CarsPark carsPark = new CarsPark(min,max);
            Compare compare = new Compare();
            int price = carsPark.getPrice();
            req.setAttribute("price", price);
            req.setAttribute("electricList",carsPark.getElectricList());
            req.setAttribute("electricCompare",compare.electricCompare());
            req.setAttribute("gasolineList",carsPark.getGasolineList());
            req.setAttribute("gasolineCompare",compare.gasolineCompare());
            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("/WEB-INF/views/carsList.jsp");
            dispatcher.forward(req, resp);
           }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher
                = req.getRequestDispatcher("/WEB-INF/views/startPage.jsp");
        dispatcher.forward(req, resp);
    }
}
