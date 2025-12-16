const BASE_URL = "http://localhost:8080/api";

export const getPackages = () =>
  fetch(`${BASE_URL}/packages`).then(res => res.json());

export const submitQuotation = data =>
  fetch(`${BASE_URL}/quotations`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  }).then(res => res.json());

export const getQuotations = () =>
  fetch(`${BASE_URL}/quotations`).then(res => res.json());

export const updateQuotation = (id, data) =>
  fetch(`${BASE_URL}/quotations/${id}`, {
    method: "PATCH",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data)
  });
