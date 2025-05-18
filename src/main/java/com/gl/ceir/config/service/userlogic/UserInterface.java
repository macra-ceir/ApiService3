package com.gl.ceir.config.service.userlogic;

import org.springframework.stereotype.Service;

@Service
public interface UserInterface {

    public <T> T getUserDetailDao(String userName, String password, int parentId);

    public <T> T getUserDetailDao(String userName, String password);

}





//public <T> T getByUsernameAndPasswordAndParentId(String userName, String password, int parentId) {
//    if (dialect.toLowerCase().contains("mysql")) {
//        return (T) userRepository
//                .getByUsernameAndPasswordAndParentId(userName, password, parentId);
//    } else {
//        return (T) usersRepository
//                .getByUsernameAndPasswordAndParentId(userName, password, parentId);
//    }
//}


