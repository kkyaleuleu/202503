import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 仮のメールアドレス名とパスワード（データベース確認部分）
        String validUsername = "user123@icloud.com";
        String validPassword = "password123";

        if (username.equals(validUsername) && password.equals(validPassword)) {
            // ログイン成功
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("index.html"); // トップページへリダイレクト
        } else {
            // ログイン失敗
            response.sendRedirect("login.html?error=1"); // エラーメッセージ付きで再度ログイン画面
        }
    }
}
