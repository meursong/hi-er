package com.mulcam.hier.dao;

import com.mulcam.hier.dto.Messages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MessagesDAO {
    public void send_message(Messages msg) throws Exception;

}
