package com.example.ecommerce.user.domain;

import com.example.ecommerce.order.domain.Order;
import com.example.ecommerce.shoppingcart.domain.ShoppingCart;
import com.example.ecommerce.user.domain.adress.Address;
import com.example.ecommerce.user.domain.payment.Payment;
import com.example.ecommerce.user.domain.vo.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UserId userId;

    private UserName name;

    private UserSurname surname;

    private UserPhone phone;

    private UserEmail email;

    private UserPassword password;

    @OneToOne(mappedBy = "user")
    private ShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Payment> payments;

    public String id() {
        return userId.value();
    }

    public String name() {
        return name.value();
    }

    public String surname() {
        return surname.value();
    }

    public String phone() {
        return phone.value();
    }

    public String email() {
        return email.value();
    }

    public String password() {
        return password.value();
    }
}
