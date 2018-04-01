--// package PKGSIN_INTERFAZ_SPV
CREATE OR REPLACE PACKAGE PKGSIN_INTERFAZ_SPV IS 
   PROCEDURE get_policy(pPolicyNumber in varchar2, pInciso in number, pCursor out Sys_RefCursor) ;
END PKGSIN_INTERFAZ_SPV;


CREATE OR REPLACE PACKAGE BODY PKGSIN_INTERFAZ_SPV IS 
   PROCEDURE get_policy(pPolicyNumber in varchar2, pInciso in number, pCursor out Sys_RefCursor) AS
   BEGIN
    OPEN pCursor FOR
    SELECT * FROM DUAL;
   END;
END PKGSIN_INTERFAZ_SPV;

--//@UNDO
-- SQL to undo the change goes here.
DROP PACKAGE MIDAS.PACKAGE PKGSIN_INTERFAZ_SPV;
;


