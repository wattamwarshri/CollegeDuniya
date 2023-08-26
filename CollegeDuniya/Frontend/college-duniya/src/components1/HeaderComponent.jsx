import React from 'react'

const HeaderComponent = () => {
  return (
    <div>
      <header className="App-header">
                    <nav className="navbar navbar-expand-lg  navbar-dark bg-dark">
                        <div className="container-fluid">
                            <a className="navbar-brand" href="/">CollegeDuniya</a>
                           
                            <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                                <div className="navbar-nav">
                                    <a className="nav-link active" aria-current="page" href="/students">Students</a>
                                    <a className="nav-link" href="#">Departments</a>
                                    <a className="nav-link" href="#">Courses</a>
                                    <a className="nav-link" href="#">Professors</a>
                                    <a className="nav-link" href="#">Subjects</a>
                                    
                                </div>
                            </div>
                        </div>
                    </nav>
                </header>
    </div>
  )
}

export default HeaderComponent
