package com.example.ecommerce.user.application.find;

import com.example.ecommerce.shared.domain.criteria.Criteria;
import com.example.ecommerce.user.domain.User;
import com.example.ecommerce.user.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaUserFinder {

    private final UserRepository userRepository;

    public CriteriaUserFinder(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> find(final Criteria criteria) {
        return userRepository.findByCriteria(criteria);
    }
}
