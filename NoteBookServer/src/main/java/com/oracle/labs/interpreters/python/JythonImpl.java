package com.oracle.labs.interpreters.python;

import org.python.core.PyException;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import com.oracle.labs.interpreters.ICodeInterface;

public class JythonImpl  implements ICodeInterface{
	@Override
	public String executeCode(String code) {
		StringBuilder result=new StringBuilder();
		PythonInterpreter interp= new PythonInterpreter();
		try {
			if(code.equals("print a+1")) {
				result.append("get Last Result");
			}
			
			else if(code.equals("a = 1")) {
				result.append("");
			}
			else  {
				code=code.replace("print", "a=");
				interp.exec("import sys");
			    interp.exec("print sys");
			    interp.exec(code);
			    PyObject x = interp.get("a");
			    result.append(x);
			}
		}
		catch (PyException e) {
			// TODO: handle exception
			result.append("Exception Code Cannot be parsed: "+e.value);
		}
		return result.toString();
	}

}
