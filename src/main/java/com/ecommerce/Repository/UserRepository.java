//
//
//package com.ecommerce.Repository;
//
//import com.ecommerce.Entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User,Long> {
//    User findByEmailAndPassword(String email, String password);
//}

package com.ecommerce.Repository;

import com.ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

}