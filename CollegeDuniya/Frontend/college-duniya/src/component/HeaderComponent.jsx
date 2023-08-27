import React from 'react'

const HeaderComponent = () => {
  return (
    <div>
      <header className="App-header">
                    <nav className="navbar navbar-expand-lg  navbar-dark bg-dark">
                        <div className="container-fluid">
                        {/* <img src="%PUBLIC_URL%/fav-icon1.png" alt="not found" /> */}
                        
                            <a className="navbar-brand" href="/">CollegeDuniya</a>
                           
                            <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                                <div className="navbar-nav">
                                    <a className="nav-link active" aria-current="page" href="/students">Students</a>
                                    <a className="nav-link" href="/departments">Departments</a>
                                    <a className="nav-link" href="courses">Courses</a>
                                    <a className="nav-link" href="/professors">Professors</a>
                                    <a className="nav-link" href="/subjects">Subjects</a>
                                    <a className="nav-link" href="/exams">Exams</a>
                                    
                                </div>
                            </div>
                        </div>
                    </nav>
                </header>
    </div>
  )
}

export default HeaderComponent
