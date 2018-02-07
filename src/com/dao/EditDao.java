package com.dao;

import java.util.List;

import com.bean.Edit;

public interface EditDao {
    void ajouter( Edit edit );
    List<Edit> lister();
}
