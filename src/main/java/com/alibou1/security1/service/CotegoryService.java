package com.alibou1.security1.service;



import com.alibou1.security1.dto.CotegoryDTO;
import com.alibou1.security1.entity.Category;

import java.util.List;

public interface CotegoryService {
    public Category getOneById(int id);
    public List<Category> getAll();
    public CotegoryDTO createCotegory(Category cotegory);
    public CotegoryDTO createNewCotegory(CotegoryDTO cotegoryDTO);
    public CotegoryDTO getOne(Category tasks);
    public CotegoryDTO update(int id, String salary);

    public void deleteCotegory(int id);


}
