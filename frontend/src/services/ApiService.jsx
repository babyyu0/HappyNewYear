import Axios from "axios";
const api = Axios.create({
    baseURL: process.env.REACT_APP_SERVER_URL,
    headers: {
      "Content-Type": "application/json;charset=UTF-8",
      "Access-Control-Allow-Origin": process.env.REACT_APP_SERVER_URL,
    }
  });

export { api };