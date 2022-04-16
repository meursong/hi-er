package com.mulcam.hier.service;

import com.mulcam.hier.dao.MessagesDAO;
import com.mulcam.hier.dto.Messages;
import com.mulcam.hier.dto.ProductList;
import com.mulcam.hier.others.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesDAO md;

    @Override
    public void send_message(Messages msg) throws Exception {
        md.send_message(msg);

    }

    @Override
    public void delete_message(Messages msg) throws Exception {
        md.delete_message(msg);
    }

    @Override
    public List<Messages> message_list(Messages params) throws Exception {
        List<Messages> msg_list= Collections.emptyList();

        int count = md.message_count(params);

        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(count);

        params.setPaginationInfo(paginationInfo);

        if (count > 0) {
            msg_list = md.message_list(params);
        }


        return msg_list;
    }

    @Override
    public List<Messages> message_view(Integer params) throws Exception {
        List<Messages> msg_list = md.message_view(params);

        if (msg_list.get(0).getRead_chk() == 1) {
            md.read_chk(params);
            return msg_list;
        }
        return msg_list;
    }


}
