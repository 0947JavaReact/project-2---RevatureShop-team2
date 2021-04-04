import axios from 'axios';


const ITEM_API_BASE_URL = "http://localhost:9025/store";

class ItemServices{
    getItems(){
        return axios.get(ITEM_API_BASE_URL+ "/allitems" )
    }
    createItem(item){
        return axios.get(ITEM_API_BASE_URL + '/create',item)
    }
    getItemByName(name){
        return axios.get(ITEM_API_BASE_URL + '/' + name,name)
    }
    
}

export default new ItemServices()