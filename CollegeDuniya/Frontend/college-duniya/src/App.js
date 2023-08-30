import './App.css';
import FooterComponent from './component/FooterComponent';
import HeaderComponent from './component/HeaderComponent';
import LoginComponent from './component/LoginComponent';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ListDepartmentComponent from './component/department/ListDepartmentComponent';
import AddOrUpdateDepartmentComponent from './component/department/AddOrUpdateDepartmentComponent';
import ListProfessorComponent from './component/professor/ListProfessorComponent';
import AddOrUpdateProfessorComponent from './component/professor/AddOrUpdateProfessorComponent';
import ListCourseComponent from './component/course/ListCourseComponent';
import AddOrUpdateCourseComponent from './component/course/AddOrUpdateCourseComponent';
import AddOrUpdateStudentComponent from './component/student/AddOrUpdateStudentComponent';
import ListStudentComponent from './component/student/ListStudentComponent';
import ListSubjectComponent from './component/subject/ListSubjectComponent';
import AddOrUpdateSubjectComponent from './component/subject/AddOrUpdateSubjectComponent';
import AddOrUpdateExamComponent from './component/exam/AddOrUpdateExamComponent';
import ListExamComponent from './component/exam/ListExamComponent';
import SignUpComponent from './component/SignUpComponent';
import HomePageComponent from './component/HomePageComponent';


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
            <Route path="/add-professor" element={<AddOrUpdateProfessorComponent />} />
            <Route path="edit-professor/:id" element={<AddOrUpdateProfessorComponent />} />

            {/* Course Routing */}
            <Route path="/courses" element={<ListCourseComponent />} />        
            <Route path="/add-course" element={<AddOrUpdateCourseComponent/>} />
            <Route path="edit-course/:id" element={<AddOrUpdateCourseComponent />} />

            {/* Subject Routing */}
            <Route path="/subjects" element={<ListSubjectComponent />} />
            <Route path="/add-subject" element={<AddOrUpdateSubjectComponent />} />
            <Route path="edit-subject/:id" element={<AddOrUpdateSubjectComponent />} />
            
            {/* Exam Routing */}
            <Route path="/exams" element={<ListExamComponent />} />
            <Route path="/add-exam" element={<AddOrUpdateExamComponent />} />
            <Route path="edit-exam/:id" element={<AddOrUpdateExamComponent />} />

            {/* Student Routing */}
            <Route path="/students" element={<ListStudentComponent />} />
            <Route path="/add-student" element={<AddOrUpdateStudentComponent/>} />
            <Route path="edit-student/:id" element={<AddOrUpdateStudentComponent/>} />
            
             {/* Trial Components */}
          <Route path="/sign-up" element={<SignUpComponent />} />
          <Route path ="/home-page" element={<HomePageComponent/>} />

          </Routes>
        </div>
        <FooterComponent />

      </Router>
    </div>
    
  );
}

export default App;
