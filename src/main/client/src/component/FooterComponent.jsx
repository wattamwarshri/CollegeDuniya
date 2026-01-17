import React from "react";

const FooterComponent = () => {
  return (
    <div>
      <footer
        className="bg-dark text-center text-white"
        style={{
          position: "static",
          bottom: 0,
          width: 100 + "%",
          height: 67 + "px",
        }}
      >
        <div
          className="text-center p-3"
          style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}
        >
          <a className="text-white" href="/" style={{ textDecoration: "none" }}>
            All Rights Reserved 2023 @CollegeDuniya.com
          </a>
        </div>
      </footer>
      {/* <footer className="footer">
                    <span className="text-muted">All Rights Reserved 2023 @CollegeDuniya.com</span>

                </footer> */}
    </div>
  );
};

export default FooterComponent;
