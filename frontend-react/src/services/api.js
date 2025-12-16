import axios from "axios";

const MyURL = "http://localhost:8080/api";

export function getPackages() {
  return axios.get(MyURL + "/packages")
    .then(response => response.data);
}

export function submitQuotation(data) {
  return axios.post(MyURL + "/quotations",data)
    .then(response => response.data);
}
  export function getQuotations() {
  return axios.get(MyURL + "/quotations")
    .then(response => response.data);
}

export function updateQuotation(id,data) {
  return axios.patch(MyURL + "/quotations/" +id, data);
}
