import { api } from "./ApiService";

const getBusinessList = async () => {
    try {
        const response = await api.get(`/business`);
        return response.data;
    } catch (error) {
        alert((error.response) ? error.response.data.message : process.env.REACT_APP_ERROR_MESSAGE);
        return;
    } 
}

export { getBusinessList };