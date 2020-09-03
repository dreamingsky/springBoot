package com.young.application.service;

import com.young.application.entity.Image;
import com.young.application.request.ImageBean;
import com.young.application.request.Pager;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface ImageService {

    Pager findImageListByPage(ImageBean bean);

    void saveImage(Image image);
    Image findImageById(Long id);

    void deleteImage(Image image);
}