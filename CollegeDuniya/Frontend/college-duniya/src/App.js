import './App.css';
import FooterComponent from './component/FooterComponent';
import HeaderComponent from './component/HeaderComponent';
import LoginComponent from './component/LoginComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListDepartmentComponent from './component/department/ListDepartmentComponent';


function App() {
  return (

    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            {/* <Route  path="/" exact element={<ListStudentComponent />} /> */}
            <Route  path="/" exact element={<LoginComponent />} />
            <Route path="/departments"  element={<ListDepartmentComponent/>} />
            {/* <Route path="/students" element={<ListStudentComponent />} /> */}
            {/* <Route path="/add-student" element={<AddStudentComponent />} /> */}
            {/* <Route path="/edit-student/:id" element={<AddStudentComponent />} /> */}
            {/* <Route path="delete-student" element={<LoginComponent />} /> */}

          </Routes>
        </div>
        <FooterComponent />

      </Router>
    </div>
    
  );
}

export default App;
