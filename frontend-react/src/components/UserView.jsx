import { useEffect, useState } from "react";
import { getPackages, submitQuotation } from "../services/api";

export default function UserView() {
  const [packages, setPackages] = useState([]);
  const [form, setForm] = useState({});
  const [id, setId] = useState(null);

  useEffect(() => {
    getPackages().then(setPackages);
  }, []);

  const submit = () => {
    submitQuotation(form).then(res => setId(res.quotationId));
  };

  return (
    <div>
      <select onChange={e => setForm({ ...form, packageName: e.target.value })}>
        <option>Select Package</option>
        {packages.map(p => (
          <option key={p.id}>{p.name}</option>
        ))}
      </select>

      <input placeholder="Name" onChange={e => setForm({ ...form, name: e.target.value })} />
      <input placeholder="Phone" onChange={e => setForm({ ...form, phone: e.target.value })} />
      <input placeholder="Location" onChange={e => setForm({ ...form, location: e.target.value })} />

      <button onClick={submit}>Submit</button>
      {id && <p>Quotation ID: {id}</p>}
    </div>
  );
}
