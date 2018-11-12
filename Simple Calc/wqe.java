int n;
      
         if(q.contains("+")){
            String[] parts= q.split("\\+");   
            double jieguo=Double.parseDouble(parts[0]);
            for(int i=1; i<parts.length; i++)
               jieguo += Double.parseDouble(parts[i]);
            result.setText(String.valueOf(jieguo));
         } else if (q.contains("-")){
            String[] parts= q.split("\\-");   
            double jieguo=Double.parseDouble(parts[0]);
            for(int i=1; i<parts.length; i++)
               jieguo -= Double.parseDouble(parts[i]);
            result.setText(String.valueOf(jieguo));
         } else if (q.contains("*")){
            String[] parts= q.split("\\*");   
            double jieguo=Double.parseDouble(parts[0]);
            for(int i=1; i<parts.length; i++)
               jieguo *= Double.parseDouble(parts[i]);            
            result.setText(String.valueOf(jieguo));
         }  else if(q.contains("/")){
            String[] parts= q.split("\\/");   
            double jieguo=Double.parseDouble(parts[0]);
            for(int i=1; i<parts.length; i++)
               jieguo /= Double.parseDouble(parts[i]);
            result.setText(String.valueOf(jieguo));
         }