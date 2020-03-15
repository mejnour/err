package com.mps.err.business.model.dto.adapter;

import com.mps.err.business.model.UserHashedJwt;
import com.mps.err.business.model.dto.UserDTO;
import com.mps.err.utils.KeyUtils;

public class UserMapper {

/*     public static UserDTO toPreservationDTO(UserHashedJwt user) {
        return new UserDTO();
    } */

    public static UserHashedJwt toPreservation(UserDTO userDTO){
        return new UserHashedJwt()
        .setId(userDTO.getId())
        .setNome(userDTO.getNome())
        .setTokenJwtHash(KeyUtils.hashingPassword(userDTO.getTokenJwt()));
    }
}
