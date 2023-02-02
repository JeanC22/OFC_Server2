# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

from odoo import models, fields, api
from odoo.exceptions import ValidationError 

class sponsor(models.Model):
    _name = 'ofc_odoo.sponsor'
    name = fields.Char(required = True)
    email = fields.Char()
    state = fields.Boolean()
    date = fields.Datetime()
    phone = fields.Integer()
    adType = fields.Char()
    event = fields.Many2many('ofc_odoo.event', string ="Events")
    admin = fields.Many2one('res.users', required = True, ofc_admin=True)
    
        
    @api.constrains('name')
    def _validate_lenght_name(self):
        if len(str(self.name)) > 30:
            raise ValidationError("The max name length is 30")
    
    @api.onchange('phone')
    def _check_phone(self):
        if self.phone < 0:
            return{
            'warning':{
                'title': "Incorrect phone length",
                'message': "The phone may not be negative",
            }
    }
    
    @api.constrains('date')    
    def _validate_date(self):
        date_today = fields.Date().today()
        if self.date > date_today:
            raise ValidationError("The date is not equals today")
