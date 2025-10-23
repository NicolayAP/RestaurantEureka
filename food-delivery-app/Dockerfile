# Stage 1: Build the Angular app

# Utiliza una imagen de Node.js 18 como base
FROM node:18 as build

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia los archivos package.json y package-lock.json al directorio de trabajo
COPY package*.json ./

# Instala las dependencias de Node.js utilizando npm
RUN npm install

# Copia todo el código fuente de la aplicación al directorio de trabajo
COPY . .

# Ejecuta el comando de construcción de la aplicación Angular
RUN npm run build

# Stage 2: Servidor Angular usando Nginx

# Utiliza una imagen NGINX como base
FROM nginx:alpine

# Copia los archivos compilados de la aplicación Angular desde la etapa anterior 
# al directorio de NGINX que se utiliza para servir archivos estáticos
COPY --from=build /app/dist/food-delivery-app /usr/share/nginx/html

# Expone el puerto 80 para acceder a la aplicación
EXPOSE 80

# Inicia el servidor NGINX en el contenedor en segundo plano
CMD ["nginx", "-g", "daemon off;"]
