import { useState } from "react";
import UserView from "./components/UserView";
import AdminView from "./components/AdminView";

export default function App() {
  const [view,setView] = useState("user");

  return (
    <div>
        <button onClick={() => setView("user")}>User view</button>
      <button onClick={() => setView("admin")}>ADmin view</button>
      {view==="user" ? <UserView />:<AdminView />}
    </div>
  );
}
