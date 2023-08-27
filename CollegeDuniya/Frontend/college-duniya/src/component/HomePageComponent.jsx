import React from 'react'
const student = {id : 1,name : "Shri"}

const HomePageComponent = () => {

    return (
        <div>
            <div>
                <p>Hello {student.name}</p>
            </div>

            <div className='d-flex'>
                <div className="card ">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/111.webp" className="img-fluid" />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center><h5 className="card-title">Students Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/students" className="btn btn-primary">View</a> </center>
                    </div>
                </div>
                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/111.webp" className="img-fluid" />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center> <h5 className="card-title">Department Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/departments" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/111.webp" className="img-fluid" />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center> <h5 className="card-title">Courses Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/courses" className="btn btn-primary">View</a> </center>
                    </div>
                </div>
                </div>
                <div className='d-flex'>
                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/111.webp" className="img-fluid" />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center> <h5 className="card-title">Professors Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/professors" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/111.webp" className="img-fluid" />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center><h5 className="card-title">Subjects Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/subjects" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

                <div className="card">
                    <div className="bg-image hover-overlay ripple" data-mdb-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/111.webp" className="img-fluid" />
                        <a href="#!">
                            <div className="mask" style={{ backgroundColor: "rgba(251, 251, 251, 0.15)" }}></div>
                        </a>
                    </div>
                    <div className="card-body">
                        <center><h5 className="card-title">Exams Info</h5> </center>
                        <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <center><a href="/exams" className="btn btn-primary">View</a> </center>
                    </div>
                </div>

                </div>

            
        </div>
            
        
    )
}

export default HomePageComponent
