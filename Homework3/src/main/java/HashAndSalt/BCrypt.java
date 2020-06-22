package HashAndSalt;

public class BCrypt {
    public String hashSaltConversion(String plainPwd){
        String hasPwd = org.springframework.security.crypto.bcrypt.BCrypt.hashpw(plainPwd,
                        org.springframework.security.crypto.bcrypt.BCrypt.gensalt());
        return hasPwd;
    }
    public boolean isMatched(String inputPwd,String hashPwd){
        return org.springframework.security.crypto.bcrypt.BCrypt.checkpw(inputPwd,hashPwd);
        // return true if the password match

    }

//    public static void main(String[] args) {
//        BCrypt bc = new BCrypt();
//        String pwd = "Phang789";
//        String hash = "$2a$10$nzF/suPA902aVS2680LJHutg8SlElpf9cfeW1yVJrfmOeNzzNLxi2";
//        System.out.println(bc.hashSaltConversion(hash));
//    }
}
