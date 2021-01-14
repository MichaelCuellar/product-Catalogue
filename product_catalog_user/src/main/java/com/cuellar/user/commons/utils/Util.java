package com.cuellar.user.commons.utils;

import com.cuellar.user.commons.dto.UserBasicDto;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Data
@Service
public class Util {

    public static UserBasicDto getIdUser(String basic) {
        byte[] userDetail = Base64.getDecoder().decode(basic);
        String userDecode = new String(userDetail);
        Long idUser = Long.valueOf(userDecode.split(":")[0]);
        String idCredentials = userDecode.split(":")[1];
        return UserBasicDto.builder().idUser(idUser).credentials(idCredentials).build();
    }
}
