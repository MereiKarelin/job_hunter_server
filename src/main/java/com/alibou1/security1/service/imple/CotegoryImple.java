package com.alibou1.security1.service.imple;

import com.alibou1.security1.dto.CotegoryDTO;
import com.alibou1.security1.entity.Category;
import com.alibou1.security1.repository.MainRepository;
import com.alibou1.security1.service.CotegoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

    @Component
    public class CotegoryImple implements CotegoryService {

        @Autowired
        private MainRepository cotegoryRepository;

        @Override
        public Category getOneById(int id) {
            return cotegoryRepository.findById(id);
        }

        @Override
        public List<Category> getAll() {
            return cotegoryRepository.findAll();
        }




        @Override
        public CotegoryDTO getOne(Category category) {
            return new CotegoryDTO(category.getId(), category.getName(), category.getSalary(), category.getDescription(), category.getTitle(), category.getExperience(), category.getWanted(), category.getType());
        }

        @Override
        public CotegoryDTO createCotegory(Category category) {
            return new CotegoryDTO(cotegoryRepository.save(category));
        }

        @Override
        public CotegoryDTO createNewCotegory(CotegoryDTO cotegoryDTO) {
            Category category = new Category();
            category.setName(cotegoryDTO.getName());
            category.setSalary(cotegoryDTO.getSalary());
            cotegoryRepository.save(category);
            CotegoryDTO dto = new CotegoryDTO(category);
            return dto;
        }

        @Override
        public CotegoryDTO update(int id, String moneyCount) {
            cotegoryRepository.update(id, moneyCount);
            Category category = getOneById(id);
            if(category !=null){
                CotegoryDTO cotegoryes = new CotegoryDTO(category);
                return cotegoryes;
            }
            else{
                CotegoryDTO cotegoryes = new CotegoryDTO(category.getId(), category.getName(), category.getSalary(), category.getDescription(), category.getTitle(), category.getExperience(), category.getWanted(), category.getType());
                return cotegoryes;
            }
        }

        @Override
        public void deleteCotegory(int id) {
            cotegoryRepository.deleteById(id);
        }
    }


