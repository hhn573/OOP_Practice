public class Food {
    class ModelFood {
        @Id;
        @generate value

        Long foodId;
        String name;
        String discription;
        Bigdecimal price;
        Bigdecimal quanity;

        List<String> image;

        @ManyToOne
        @Joincolumn(name = "category_id")
    }

    class RequestFood {
        @NotEmpty(name "Name no to be empty")
        String name;

        @Not
    }

    @RequestMapping(/food)
    class ControllerFood {
        private FoodService foodService;

        @PostMapping
        public Food createdFood(FoodRequest foodRequest) {
            return foodService.createdFood(FoodRequest, foodRequest.getcategory);
        }

        @GetMapping(/{id})
        public Food getFoodbyId(foodId) {
            return foodService.getFoodbyId(foodId)
        }

        @DeleteMapping
        public Food deleteFoodbyId(foodId) {
            foodService.deleteFoodbyId(foodId);
            return id + "delete thanh cong"
        }
    }

   class ServiceFood {
        private FoodReposibilty foodReposibilty

       public List<Food> getFood(){
            return foodReposibilty.findAll();
       }

       public List<Food> getById(Long Id){
            return foodReposibilty.getById(Id);
           .throw new RuntimException(id + "not found");
       }

       public List<Food> getByName(String keyword) {
            return
       }
   }
}