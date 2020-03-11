package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            double n1 = Integer.parseInt(request.getParameter("numero1"));
            double n2 = Integer.parseInt(request.getParameter("numero2"));
            double resultado = 0;
            String operacion = request.getParameter("operacion");
            if(operacion.equals(" + "))
            {
                resultado = n1+n2;
                response.setStatus(200);
            }
            else if(operacion.equals(" - "))
            {
                resultado = n1-n2;
                response.setStatus(200);
            }
            else if(operacion.equals(" x "))
            {
                resultado = n1*n2;
                response.setStatus(200);
            }
            else if(operacion.equals(" / "))
            {
                resultado = n1/n2;
                response.setStatus(200);
            }
            PrintWriter out = response.getWriter();
            out.println("");
            out.println("<!DOCTYPE html>\n" + "<html lang=\"en\">");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"./CSS/styles.css\">");
            out.println("<title>Calculadora</title>\n"+"</head>");
            out.println("<body>");
            out.println("<div id=\"resultado\">");
            out.println("el resultado es: " + resultado);
            out.println("<BR><BR>");
            out.println("<a href=\"/web_war_exploded/index.html\">Volver atrás...</a>");
            out.println("<p>La fecha es: ");
            out.println("<script type=\"text/javascript\">\n" + "var d = new Date();\n");
            out.println("if(d.getMinutes()<10){document.write(d.getDate() + '/' + (d.getMonth()+1) + '/' + d.getFullYear() + ' a las ' + d.getHours() + ':0' + d.getMinutes());}\n");
            out.println("else{document.write(d.getDate() + '/' + (d.getMonth()+1) + '/' + d.getFullYear() + ' a las ' + d.getHours() + ':' + d.getMinutes());}\n");
            out.println("</script></p>");
            out.println("<p>La IP del usuario es: " + InetAddress.getLocalHost().getHostAddress());
            out.println("</p><p id=\"browser\"></p>");
            out.println("<script type=\"text/javascript\">\n" + "var sBrowser, sUsrAg = navigator.userAgent;\n" +
                    "\n" +
                    "// The order matters here, and this may report false positives for unlisted browsers.\n" +
                    "\n" +
                    "if (sUsrAg.indexOf(\"Firefox\") > -1) {\n" +
                    "  sBrowser = \"Mozilla Firefox\";\n" +
                    "  // \"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:61.0) Gecko/20100101 Firefox/61.0\"\n" +
                    "} else if (sUsrAg.indexOf(\"SamsungBrowser\") > -1) {\n" +
                    "  sBrowser = \"Samsung Internet\";\n" +
                    "  // \"Mozilla/5.0 (Linux; Android 9; SAMSUNG SM-G955F Build/PPR1.180610.011) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/9.4 Chrome/67.0.3396.87 Mobile Safari/537.36\n" +
                    "} else if (sUsrAg.indexOf(\"Opera\") > -1 || sUsrAg.indexOf(\"OPR\") > -1) {\n" +
                    "  sBrowser = \"Opera\";\n" +
                    "  // \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 OPR/57.0.3098.106\"\n" +
                    "} else if (sUsrAg.indexOf(\"Trident\") > -1) {\n" +
                    "  sBrowser = \"Microsoft Internet Explorer\";\n" +
                    "  // \"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; Zoom 3.6.0; wbx 1.0.0; rv:11.0) like Gecko\"\n" +
                    "} else if (sUsrAg.indexOf(\"Edge\") > -1) {\n" +
                    "  sBrowser = \"Microsoft Edge\";\n" +
                    "  // \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299\"\n" +
                    "} else if (sUsrAg.indexOf(\"Chrome\") > -1) {\n" +
                    "  sBrowser = \"Google Chrome\";\n" +
                    "  // \"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/66.0.3359.181 Chrome/66.0.3359.181 Safari/537.36\"\n" +
                    "} else if (sUsrAg.indexOf(\"Safari\") > -1) {\n" +
                    "  sBrowser = \"Apple Safari\";\n" +
                    "  // \"Mozilla/5.0 (iPhone; CPU iPhone OS 11_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.0 Mobile/15E148 Safari/604.1 980x1306\"\n" +
                    "} else {\n" +
                    "  sBrowser = \"unknown\";\n" +
                    "}\n" + "document.getElementById(\"browser\").innerHTML = \"El Browser es \" + sBrowser;");
            out.println("</script></p>");
            out.println("</div>");
            //out.println("<script src=\"./JS/main.js\"></script>");
            out.println("</body>");
            out.println("<html>");

        }
        catch(NumberFormatException ex)
        {
            response.sendError(500, "Introduzca solo números");
        }
    }

    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }*/
}
