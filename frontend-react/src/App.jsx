import { useState } from "react";
import UserView from "./components/UserView";
import AdminView from "./components/AdminView";

export default function App() {
  const [view, setView] = useState("user");

  return (
    <div>
      <button onClick={() => setView("user")}>User View</button>
      <button onClick={() => setView("admin")}>Admin View</button>
      {view === "user" ? <UserView /> : <AdminView />}
    </div>
  );
}
