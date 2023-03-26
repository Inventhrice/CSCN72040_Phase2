package vrmaster_user;

public abstract class User {
 PaymentInfo payment;
 String email;
 abstract public PaymentInfo getPayment();
 abstract public String getEmail();
 abstract public Boolean pay();
}
