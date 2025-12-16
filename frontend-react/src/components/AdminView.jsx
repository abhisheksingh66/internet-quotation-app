import { useEffect, useState } from "react";
import { getQuotations, updateQuotation } from "../services/api";

export default function AdminView() {
  const [data, setdata] = useState([]);

  const load = () => getQuotations().then(setdata);
  useEffect(load, []);

  const action = (id, status) => {
    const comment = prompt("enter comment");
    updateQuotation(id, { status, comment }).then(load);
  };

  return (
    <table border="1">
      {data.map(q => (
        <tr key={q.id}>
          <td>{q.name}</td>
          <td>{q.packageName}</td>
          <td>{q.status}</td>
          <td>
            <button onClick={() => action(q.id, "APPROVED")}>approve....🤗</button>
            <button onClick={() => action(q.id, "REJECTED")}>reject...🤧</button>
          </td>
        </tr>
      ))}
    </table>
  );
}
