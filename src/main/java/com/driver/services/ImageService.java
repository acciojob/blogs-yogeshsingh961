package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions)  {
        //add an image to the blog

        //try{
        Blog  blog=blogRepository2.findById(blogId).get();
//        }catch (Exception e){
//            throw new Exception("No such blog present!");
//        }
        Image image= new Image();
        image.setDescripiton(description);
        image.setDimension(dimensions);
        image.setBlog(blog); // link this blog(parent) as blog_id(fk) to image table(child)

        //set this image to imagelist of a blog
        blog.getImageList().add(image);

        blogRepository2.save(blog); //saving blog ,image will be autosaved
        return image;

    }

    public void deleteImage(Integer id){
       //Image image;
       // try{
            imageRepository2.findById(id).get();

//        }catch (Exception e){
//            throw new Exception("Image is not present!");
//        }
        //found the image

//       imageRepository2.deleteById(id);
//       Blog blog=image.getBlog();
//       blog.getImageList().remove(image);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        int indOfXinScreen=screenDimensions.indexOf('X');
        int leftScreen=Integer.parseInt(screenDimensions.substring(0,indOfXinScreen));
        int rightScreen=Integer.parseInt(screenDimensions.substring(indOfXinScreen));
        //find image object
        Image image;
      //  try{
            image=imageRepository2.findById(id).get();
//        }catch (Exception e){
//            throw new Exception("image is not present!");
//        }
       int indOfXInImage=image.getDimension().indexOf('X');
        int leftImage=Integer.parseInt(image.getDimension().substring(0,indOfXInImage));
        int rightImage=Integer.parseInt(image.getDimension().substring(indOfXInImage));

        int ans=(leftScreen/leftImage)* (rightScreen/rightImage);
        return ans;

    }
}
