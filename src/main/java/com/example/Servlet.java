package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/servlet"})
public class Servlet extends HttpServlet {

    static long counter;
    static int cycle;

    public Servlet() {
        Servlet.counter = 0; //счетчик обращения к странице
        Servlet.cycle = 1;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            String prm1 = request.getParameter("el1");
            String prm2 = request.getParameter("el2");
            String prm3 = request.getParameter("el3");
            String prm4 = request.getParameter("el4");
            String fio = request.getParameter("el5");
            String grp = request.getParameter("el6");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + fio + ",гр " + grp + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>ЗАДАНИЕ:</h3>");
            out.println("<h3>.</h3>");

            //=============I
            out.println("<h" + Servlet.cycle + "><table border>" +
                    "<tr>"
                    + "<td> el1 </td>" +
                    "<td align=\"center\">  " + prm1 + "  </td>" +
                    "<tr>" +
                    "<td> el2 </td>" +
                    "<td align=\"center\">  " + prm2 + "  </td>" +
                    "<tr>" +
                    "<td> el3 </td>" +
                    "<td align=\"center\">  " + prm3 + " </td>" +
                    "<tr>" +
                    "<td> el4 </td>" +
                    "<td align=\"center\">  " + prm4 + "  </td>" +
                    "</tr>" + "</table>" +
                    "</h" + Servlet.cycle + ">");
            out.println("<h3> Размер текста таблицы : <font color=\"blue\">h" + Servlet.cycle + "</font></h3>");

            //=============II
            int colelem = 4; //Переданные параметры
            int chetSum = 0;
            int nechetSum = 0;
            int[] elem = new int[4];
            Boolean Error = false;

            try {
                elem[0] = Integer.parseInt(prm1);
                elem[1] = Integer.parseInt(prm2);
                elem[2] = Integer.parseInt(prm3);
                elem[3] = Integer.parseInt(prm4);
            } catch (NumberFormatException e) {
                Error = true;
            }

            for (int i = 0; i < colelem; i++) {
                if (elem[i] % 2 == 0 && elem[i] < 0)
                    chetSum = chetSum + elem[i];

                if (elem[i] % 2 != 0 && elem[i] < 0)
                    nechetSum = nechetSum + elem[i];
            }
            out.println("<h3>: <font color=\"blue\">" + chetSum + "</font></h3>");
            out.println("<h3>: <font color=\"blue\">" + nechetSum + "</font></h3>");

            //=============III
            Servlet.counter++;
            if (Servlet.cycle < 5)
                Servlet.cycle++;
            else {
                out.println("<h4>Дальнейшее уменьшение невозможно</h4>");
                Servlet.cycle = 1;
            }
            out.println("<h3> Изменение триггера : <font color=\"blue\">" + Servlet.cycle + "</font></h3>");

            //=============IV
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}