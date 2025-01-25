package com.enviro.assessment.grad001.MendiMkhize.SortWaste.data;

import com.enviro.assessment.grad001.MendiMkhize.SortWaste.model.Category;
import com.enviro.assessment.grad001.MendiMkhize.SortWaste.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Data implements CommandLineRunner{


        private final CategoryRepository categoryRepository;

        public Data(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }

        @Override
        public void run(String... args) throws Exception {

            if (categoryRepository.count() == 0) {
                Category Mixed_Waste = new Category(
                        null,
                        "Mixed Waste",
                        "Dispose of in general waste bins.",
                        "Try to separate recyclable items before disposal.");


                categoryRepository.save(Mixed_Waste);
            }
        }

}
