FROM open-liberty
ADD --chown=1001:0 target/echo.tar.gz /opt/ol