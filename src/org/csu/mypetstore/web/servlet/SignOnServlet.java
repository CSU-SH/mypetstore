package org.csu.mypetstore.web.servlet;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.LogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOnServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String SIGN_ON_FORM = "/WEB-INF/jsp/account/SignonForm.jsp";

    private Account account;
    private AccountService accountService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        accountService = new AccountService();
        account = accountService.getAccount(username, password);

        HttpSession session = request.getSession();
        session.setAttribute("account", account);

        //获得输入的验证码值
        String value1=request.getParameter("vCode");
        /*获取图片的值*/
        String value2=(String)session.getAttribute("randCheckCode");
        Boolean isSame = false;
        /*对比两个值（字母不区分大小写）*/
        if(value1.equals(value2)){
            isSame = true;
        }

        if(isSame) {
            if (account == null) {
                session.setAttribute("messageSignOn", "Invalid username or password.  Signon failed.");
                session.setAttribute("account", null);
                request.getRequestDispatcher(SIGN_ON_FORM).forward(request, response);
            } else {


                    HttpServletRequest httpRequest= request;
                    String strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
                            + httpRequest.getContextPath() + httpRequest.getServletPath() + "?" + (httpRequest.getQueryString());
                    LogService logService = new LogService();
                    String logInfo = logService.logInfo(" ") + strBackUrl + " 登录成功，跳转至主界面";
                    logService.insertLogInfo(account.getUsername(), logInfo);

                account.setPassword(null);
                request.getRequestDispatcher(MAIN).forward(request, response);
            }
        }
        else{
            session.setAttribute("messageAccount", "Invalid Verification Code.");
            request.getRequestDispatcher(SIGN_ON_FORM).forward(request, response);
        }
    }
}
