import './App.css';
import FooterComponent from './component/FooterComponent';
import HeaderComponent from './component/HeaderComponent';
import LoginComponent from './component/LoginComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListDepartmentComponent from './component/department/ListDepartmentComponent';
import AddOrUpdateDepartmentComponent from './component/department/AddOrUpdateDepartmentComponent';


function App() {
  return (

    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route  path="/" exact element={<LoginComponent />} />
            <Route path="/departments"  element={<ListDepartmentComponent/>} />
            <Route path="/add-department" element={<AddOrUpdateDepartmentComponent />} />
            <Route path="/edit-department/:id" element={<AddOrUpdateDepartmentComponent />} />
            {/* <Route path="delete-student" element={<LoginComponent />} /> */}

          </Routes>
        </div>
        <FooterComponent />

      </Router>
    </div>
    
  );
}

export default App;
