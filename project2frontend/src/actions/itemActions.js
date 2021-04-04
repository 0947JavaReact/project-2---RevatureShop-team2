import {NEW_ITEM,FETCH_ITEMS} from './types'
import ItemServices from '../services/ItemService'

export const newItem = (itemData) =>dispatch => {
    ItemServices.createItem(itemData)
   
    dispatch({
        type: NEW_ITEM,
        payload:  itemData
      })
}

export const fetchItems = () => dispatch => {
    ItemServices.getItems().then(res => {
        dispatch({
            type: FETCH_ITEMS,
            payload: res.data
          })
    })
}