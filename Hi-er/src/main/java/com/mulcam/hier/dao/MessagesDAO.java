package com.mulcam.hier.dao;

import com.mulcam.hier.dto.Messages;
import com.mulcam.hier.dto.ProductList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessagesDAO {
    public void send_message(Messages msg) throws Exception;
    public List<Messages> message_list(Messages msg) throws Exception;

    public List<Messages> message_view(Integer msg) throws Exception;

    public void read_chk(Integer msg) throws Exception;

    public Integer message_count(Messages msg);

}
