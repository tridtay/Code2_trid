package com.example.rtcs;

import com.example.rtcs.entity.QRcode;
import com.example.rtcs.exception.QRcodeCantStore;
import com.example.rtcs.exception.QRcodeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class QRcodeService {

    @Autowired
    private QRcodeRepository qRcodeRepository;

    //for mockito
    public void setQRcodeRepository(QRcodeRepository qRcodeRepository) {
        this.qRcodeRepository = qRcodeRepository;
    }

    public String findQRcode(long id) {
        Optional<QRcode> result = qRcodeRepository.findById(id);
        if (result.isPresent()) {
            return "found";
        } throw new QRcodeNotFoundException("not found");
    }

    public String Generate(QRcode qRcode) throws QRcodeCantStore {
        qRcodeRepository.save(qRcode);
        Optional<QRcode> result = qRcodeRepository.findById(qRcode.getId());
        if (result.isPresent()) {
            return "Generate Success";
        } throw new QRcodeCantStore("fail to generate");
    }
}
