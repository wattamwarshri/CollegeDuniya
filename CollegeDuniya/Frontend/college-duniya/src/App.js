import './App.css';
import FooterComponent from './component/FooterComponent';
import HeaderComponent from './component/HeaderComponent';
import LoginComponent from './component/LoginComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListDepartmentComponent from './component/department/ListDepartmentComponent';
import AddOrUpdateDepartmentComponent from './component/department/AddOrUpdateDepartmentComponent';
import ListProfessorComponent from './component/professor/ListProfessorComponent';
import AddOrUpdateProfessor from './component/professor/AddOrUpdateProfessor';


function App() {
  return (

    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route  path="/" exact element={<LoginComponent />} />

            {/* Department Routing */}
            <Route path="/departments"  element={<ListDepartmentComponent/>} />
            <Route path="/add-department" element={<AddOrUpdateDepartmentComponent />} />
            <Route path="/edit-department/:id" element={<AddOrUpdateDepartmentComponent />} />
            {/* <Route path="delete-student" element={<LoginComponent />} /> */}

          {/* Professor Routing */}
          <Route path="/professors" element={<ListProfessorComponent />} />
          <Route path="/add-professor" element={<AddOrUpdateProfessor />} />
          <Route path ="edit-professor/:id" element={<AddOrUpdateProfessor />} />


          </Routes>
        </div>
        <FooterComponent />

      </Router>
    </div>
    
  );
}

export default App;
