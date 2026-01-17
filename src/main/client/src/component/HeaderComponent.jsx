import React from 'react'
import collegeLogo from '../img/fav-icon-college.jpg'
import { Link } from 'react-router-dom'
const HeaderComponent = () => {
  return (
    <div>
      <header className="App-header">
                    <nav className="navbar navbar-expand-lg  navbar-dark bg-dark">
                        <div className="container-fluid">
                        <img src={collegeLogo}  alt="not found" style={{"height":40 +"px", "width" : 40 + "px", "marginRight": 10 + "px"}}/>
                        
                            <a className="navbar-brand">CollegeDuniya</a>
                           
                            <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                                <div className="navbar-nav">
                                <Link to="/" className="btn btn-danger btn-block flex-reverese" >Logout</Link>
                                   
                                    
                                </div>
                            </div>
                        </div>
                    </nav>
                </header>
    </div>
  )
}

export default HeaderComponent
