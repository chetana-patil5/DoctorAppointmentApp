import axios from 'axios';
const BASE_URL="http://localhost:8080/category/";

class CategoryService{
    getAllCategory(){
        return axios.get(BASE_URL);
    }

    getByCategory(id){
        return axios.get(BASE_URL + "_id", id)
    }

    
}
export default new CategoryService;